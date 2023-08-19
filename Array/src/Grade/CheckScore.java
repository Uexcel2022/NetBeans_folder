
package Grade;

public class CheckScore {

    public String checkScore2(int score) {

        if (score > 100) {
            return "Invalid score";
        } else if (score >= 80) {
            return "Outstanding";
        } else if (score >= 70) {
            return "Excellent";
        } else if (score >= 60) {
            return " good";
        } else if (score >= 50) {
            return "Credit";
        } else if (score >= 40) {
            return "Pass";
        } else if (score < 40) {
            if (score < 0) {
                return "Invalid score";
            } else {
                return "Fail";
            }
        }

        return "Could not resolve request";
    }
}
