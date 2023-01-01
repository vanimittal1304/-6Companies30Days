import java.util.ArrayList;
import java.util.List;

// combination 
//     if we have n then we can select numbers from 1 to n. 
//     lets say we have n = 4 
//     now we can select k no. only from 1 to 4
//     lets say k = 2 (no. of elements)
//          possibilities : (1,2),(1,3),(1,4),(2,3),(2,3),(3,4)

// i=0 (   )
//     /    \
//    /      \
//   /        \
// i=1 (1)         ()
//         /\        /\ 
//        /  \      /  \ 
// i=2 (1,2)  (1)    (2)  ()
//                        /\     / \
//                       /  \   /   \
// i=3                (1,3) (1)(2,3) (2) ...

//  we will be using backtracking for avoiding unnecessary nodes

public class Microsoft2 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        backtrack(candidates, 0, target, new ArrayList(), result);
        return result;
    }

    private void backtrack(int[] cand, int start, int target, List<Integer> list, List<List<Integer>> result) {
        if (target < 0)
            return;
        if (target == 0)
            result.add(new ArrayList(list));
        for (int i = start; i < cand.length; i++) {
            list.add(cand[i]);
            backtrack(cand, i, target - cand[i], list, result);
            list.remove(list.size() - 1);
        }
    }
}
