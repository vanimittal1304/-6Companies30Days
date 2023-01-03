import java.util.ArrayList;
import java.util.List;
//  Q- Combination Sum with a twist.

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

public class CombinationSumWithaTwist {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;

    }

    void backtrack(List<List<Integer>> result, List<Integer> list, int k, int tot, int start) {
        if (list.size() > k)
            return;
        if (list.size() == k && tot == 0)
            result.add(new ArrayList<>(list));
        for (int i = start; i <= 9; i++) {
            list.add(i);
            backtrack(result, list, k, tot - i, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
