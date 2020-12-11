public class L649_PredictPartyVictory {

    public String predictPartyVictory(String senate) {
        if (senate == null || senate.length() == 0) return "";
        if (senate.length() == 1) return senate.equals("R") ? "Radiant" : "Dire";

        char[] senators = senate.toCharArray();

        int len = senators.length;
        while(true) {
            for (int i = 0; i < len; i++) {
                if (senators[i] == 'R') {
                    if (!ban(senators, len, i, 'D')) return "Radiant";
                } else if (senators[i] == 'D'){
                    if (!ban(senators, len, i, 'R')) return "Dire";
                }
            }
        }
    }

    private boolean ban(char[] senators, int len, int i, char k) {
        for (int j = i + 1; j < len + i; j++) {
            int n = j < len ? j : j % len;
            if (senators[n] == k) {
                senators[n] = 'X';
                return true;
            }
        }
        return false;
    }
}
