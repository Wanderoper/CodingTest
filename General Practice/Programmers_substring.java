class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = my_string.substring(0,s) + overwrite_string;
        
        if(my_string.length() > answer.length()) {
            answer += my_string.substring(answer.length());
        }
        return answer;     
    }
}

// 이전풀이 

//class Solution {
//    public String solution(String my_string, String overwrite_string, int s) {
//        String answer = "";
//        int last_index = (s + overwrite_string.length());
//        for (int i = 0; i < my_string.length() ; i++) {
//            if (i >= s && i < last_index) {
//                answer += overwrite_string.charAt(i - s);
//            }
//            else {
//                answer += my_string.charAt(i);
//            }
//        }
//        return answer;
//    }
//}