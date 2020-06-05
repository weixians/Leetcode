class PermutationSequence_60_Online {
    /**
     * 该方法源于对数据的观察，通过观察得到：
     *  (k - 1) / (n - 1)!  + 1 determines which number in [1, n] comes first，以此类推
     *
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        int[] factorials = new int[n];
        factorials[0] = 1;
        for (int i = 1; i < factorials.length; ++i) {
            factorials[i] = i * factorials[i - 1];
        }
        boolean[] used = new boolean[n];
        int remainder = k - 1;
        StringBuilder answer = new StringBuilder();
        for (int i = n - 1; i >= 0; --i) {
            int offset = remainder / factorials[i];
            for (int j = 0; j < used.length; ++j) {
                //一个数有且只有出现一次
                if (used[j]) {
                    continue;
                }
                if (offset == 0) {
                    answer.append(j + 1);
                    used[j] = true;
                    break;
                }
                --offset;
            }
            remainder %= factorials[i];
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        PermutationSequence_60_Online tc = new PermutationSequence_60_Online();
        int n = 4, k = 6;
        System.out.println(tc.getPermutation(n, k));
    }
}