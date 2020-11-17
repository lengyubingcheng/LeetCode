import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isSubsequence("axc"
                , "ahbgdc"));
        System.out.println(-12 % -5);
        StringBuilder sb = new StringBuilder();
        Math.max(1,2);
        System.out.println(sum(1,23,23));
        int m = 3, n = 6,k =0;
        while ((m++) < (--n)) ++k;
        System.out.println(k);
    }

    public static int sum(int ...args)  {
        int result = 0;
        for(int arg : args) {//当作数组用foreach遍历
            result+=arg;
        }
        return result;
    }

    double quickMul(double x, long n) {
        double result = 1;
        double xContribute = x;
        while (n > 0) {
            if (n % 2 == 1) {
                result *= xContribute;
            }
            xContribute *= xContribute;
            n /= 2;
        }
        return result;
    }

    public double myPow(double x, int n) {
        return (long) n >= 0 ? quickMul(x, n) : 1.0 / quickMul(x, -(long) n);
    }

    /**
     * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
     * 给出两个整数 x 和 y，计算它们之间的汉明距离。
     * 注意：
     * 0 ≤ x, y < 231.
     *
     * @param x 整数
     * @param y 整数
     * @return 汉明距离
     */
    public int hammingDistance(int x, int y) {
        x = x < 0 ? -x : x;
        y = y < 0 ? -y : y;
        int count = 0;
        while (x >= 0 || y >= 0) {
            if (x % 2 != y % 2) {
                count++;
            }
            x /= 2;
            y /= 2;
            if (x == 0 && y == 0) {
                break;
            }
        }
        return count;
    }

    public int rangeSumBST(TreeNode root, int l, int r) {
        if (root.val != l && root.val != r) {
            if (root.val < l) {

            }
        }
        return 1;

    }

    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     *
     * @param head 头节点
     * @return 数组
     */
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }
        int size = stack.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = stack.pop();
        }
        return result;
    }

    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     *
     * @param s 字符串
     * @return 替换后的字符串
     */
    public String replaceSpace(String s) {
        int length = s.length();
        int lengthAfterReplace = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                lengthAfterReplace += 3;
            } else {
                lengthAfterReplace += 1;
            }
        }
        char[] chars = new char[lengthAfterReplace];
        char a = chars[0];
        int j = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                chars[j++] = '%';
                chars[j++] = '2';
                chars[j++] = '0';
            } else {
                chars[j++] = c;
            }
        }
        return String.valueOf(chars);
    }

    public int countNegatives(int[][] grid) {
        int xLength = grid[0].length;
        int count = 0;
        for (int[] ints : grid) {
            for (int j = 0; j < xLength; j++) {
                if (ints[j] < 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public int oddCells(int n, int m, int[][] indices) {
        boolean[][] grid = new boolean[n][m];
        int count = 0;
        for (int[] index : indices) {
            int x = index[0];
            for (int i = 0; i < m; i++) {
                grid[x][i] = !grid[x][i];
                count += grid[x][i] ? 1 : -1;
            }
            int y = index[1];
            for (int j = 0; j < n; j++) {
                grid[j][y] = !grid[j][y];
                count += grid[j][y] ? 1 : -1;
            }
        }
        return count;
    }

    /**
     * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
     *
     * @param str 字符串参数
     * @return 转成小写后的字符串
     */
    public String toLowerCase(String str) {
        int size = str.length();
        char[] chars = new char[size];
        for (int i = 0; i < size; i++) {
            byte byteAscii = (byte) str.charAt(i);
            byte byteAsciiAfterLower = (byteAscii >= 65 && byteAscii <= 90) ? (byte) (byteAscii + 32) : byteAscii;
            chars[i] = (char) byteAsciiAfterLower;
        }
        return String.valueOf(chars);
    }

    public int maximum69Number(int num) {
        String string = String.valueOf(num);
        int size = string.length();
        char[] chars = new char[size];
        boolean flag = true;
        for (int i = 0; i < size; i++) {
            if (string.charAt(i) == '6' && flag) {
                chars[i] = '9';
                flag = false;
            } else {
                chars[i] = string.charAt(i);
            }
        }
        return Integer.parseInt(String.valueOf(chars));
    }

    public int uniqueMorseRepresentations(String[] words) {
        String[] morseCode = {
                ".-", "-...", "-.-.", "-..", ".",
                "..-.", "--.", "....", "..", ".---",
                "-.-", ".-..", "--", "-.", "---",
                ".--.", "--.-", ".-.", "...", "-",
                "..-", "...-", ".--", "-..-", "-.--",
                "--..",
        };
        Set<String> result = new HashSet<>();
        for (String word : words) {
            int size = word.length();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < size; i++) {
                int index = (byte) word.charAt(i) - 97;
                stringBuilder.append(morseCode[index]);
            }
            result.add(stringBuilder.toString());
        }
        return result.size();
    }

    public boolean canBeEqual(int[] target, int[] arr) {
        int[] a = new int[1001];
        int[] b = new int[1001];
        for (int i : target) {
            a[i]++;
        }
        for (int j : arr) {
            b[j]++;
        }
        for (int i = 0; i < 1001; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(head.val);
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
            stack.push(p.val);
        }
        ListNode q = new ListNode(stack.pop());
        ListNode listNode = q;
        while (!stack.empty()) {
            q.next = new ListNode(stack.pop());
            q = q.next;
        }
        return listNode;
    }

    public int[][] flipAndInvertImage(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int a = A[i][j] ^ 1;
                A[i][j] = A[i][n - j - 1] ^ 1;
                A[i][n - j - 1] = a;
            }
        }
        return A;
    }

    public int[] sumZero(int n) {
        int[] result = new int[n];
        int m = n / 2;
        for (int i = 0; i < m; i++) {
            result[i] = i - m;
            result[n - i - 1] = m - i;
        }
        return result;
    }

    public int[] finalPrices(int[] prices) {
        int size = prices.length;
        for (int i = 0; i < size; i++) {
            int price = prices[i];
            boolean flag = true;
            for (int j = i + 1; j < size; j++) {
                if (prices[j] <= price && flag) {
                    prices[i] = price - prices[j];
                    flag = false;
                }
                if (j == size - 1 && flag) {
                    prices[i] = price;
                }
            }
        }
        return prices;
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            String string = String.valueOf(i);
            int size = string.length();
            boolean flag = true;
            for (int j = 0; j < size; j++) {
                int c = Integer.parseInt(String.valueOf(string.charAt(j)));
                if (c == 0 || i % c != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(i);
            }
        }
        return list;
    }

    public boolean judgeCircle(String moves) {
        int size = moves.length();
        int flag1 = 0;
        int flag2 = 0;
        for (int i = 0; i < size; i++) {
            switch (moves.charAt(i)) {
                case 'U':
                    flag1++;
                    break;

                case 'D':
                    flag1--;
                    break;

                case 'L':
                    flag2++;
                    break;

                case 'R':
                    flag2--;
                    break;
                default:
                    break;
            }
        }
        return flag1 == 0 && flag2 == 0;
    }

    public String freqAlphabets(String s) {
        int size = s.length();
        int index = size - 1;
        StringBuilder result = new StringBuilder();
        while (index >= 0) {
            if (s.charAt(index) == '#') {
                char m = (char) (Integer.parseInt(s.substring(index - 2, index)) + 96);
                result.insert(0, m);
                index -= 3;
            } else {
                char m = (char) (Integer.parseInt(s.substring(index, index + 1)) + 96);
                result.insert(0, m);
                index -= 1;
            }
        }
        return String.valueOf(result);
    }

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n = n >>> 1;
        }
        return count;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode result = new ListNode(0);
        ListNode p = result;
        while (p1 != null || p2 != null) {
            if (p1 == null || p2 != null && p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;

            } else {
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }
        return result;
    }

    public int heightChecker(int[] heights) {
        int[] arr = new int[101];
        for (int height : heights) {
            arr[height]++;
        }
        int result = 0;
        int size = arr.length;
        for (int i = 1, j = 0; i < size; i++) {
            while (arr[i]-- > 0) {
                if (heights[j++] != i) {
                    result++;
                }
            }
        }
        return result;
    }

    public int[] runningSum(int[] nums) {
        int size = nums.length;
        int lastResult = 0;
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = lastResult + nums[i];
            lastResult = result[i];
        }
        return result;
    }

    public int numIdenticalPairs(int[] nums) {
        int size = nums.length;
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }


    public boolean isSubsequence(String s, String t) {
        int sSize = s.length();
        int tSize = t.length();
        if (sSize == 0) {
            return true;
        } else {
            String sSub = s.substring(0, 1);
            for (int i = 0; i < tSize; i++) {
                boolean equals = t.substring(i, i + 1).equals(sSub);
                if (equals) {
                    return isSubsequence(s.substring(1), t.substring(i + 1));
                }
            }
            return false;
        }
    }

    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
        int size = candies.length;
        for (int candy : candies) {
            maxCandies = Math.max(maxCandies, candy);
        }
        List<Boolean> result = new ArrayList<>(size);
        for (int candy : candies) {
            result.add((candy + extraCandies) >= maxCandies);
        }
        return result;
    }

    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[n * 2];
        for (int i = 0; i < n; i++) {
            result[2 * i] = nums[i];
            result[2 * i + 1] = nums[i + n];
        }
        return result;
    }

    public int xorOperation(int n, int start) {
        int result = start;
        for (int i = 1; i < n; i++) {
            result = result ^ (start + 2 * i);
        }
        return result;
    }

    public String reverseLeftWords(String s, int n) {
        String string1 = s.substring(n);
        String string2 = s.substring(0, n);
        return string1 + string2;
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public int numJewelsInStones(String J, String S) {
        int sSize = S.length();
        int jSize = J.length();
        int count = 0;
        for (int i = 0; i < sSize; i++) {
            char s = S.charAt(i);
            for (int j = 0; j < jSize; j++) {
                if (s == J.charAt(j)) {
                    count++;
                }
            }
        }
        return count;
    }

    public String defangIPaddr(String address) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            char c = address.charAt(i);
            if (c == '.') {
                stringBuilder.append("[.]");
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public int game(int[] guess, int[] answer) {
        int count = 0;
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == answer[i]) {
                count++;
            }
        }
        return count;
    }

    public int subtractProductAndSum(int n) {
        int sum = 0;
        int mul = 1;
        while(n > 0){
            int m = n % 10;
            sum += m;
            mul *= m;
            n /= 10;
        }
        return Math.abs(sum - mul);
    }
    public int minCount(int[] coins) {
        int size = coins.length;
        int count = 0;
        for (int coin : coins) {
            count += coin / 2 + coin % 2 == 0 ? 0 : 1;
        }
        return count;
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    public static class CQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            if (stack2.isEmpty()) {
                return -1;
            } else {
                return stack2.pop();
            }
        }
    }
    public int numberOfSteps (int num) {
        int count = 0;
        while(num > 0){
           if(num % 2 == 0){
               num = num / 2;
           }else {
               num -= 1;
           }
           count++;
        }
        return count;
    }

    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> temp = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++)
        {
            temp.add(index[i], nums[i]);
        }
        int[] target = new int[n];
        for(int i = 0; i < n; i++){
            target[i] = temp.get(i);
        }
        return target;
    }
    public int[] decompressRLElist(int[] nums) {
        int len = 0;
        for (int i = 0; i < nums.length; i=i+2) {
            len += nums[i];
        }
        int[] result = new int[len];
        int index = 0;
        for (int i = 0; i < nums.length; i=i+2) {
            for (int j = 0; j < nums[i]; j++) {
                result[index] = nums[i+1];
                index++;
            }
        }
        return result;
    }
    public int sumNums(int n) {
        return (1 + n) * n / 2;
    }
}