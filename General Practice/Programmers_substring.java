class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
    	// 한번에 overwrite_string까지 붙여넣는다 
        String answer = my_string.substring(0,s) + overwrite_string;
        
        // 만약 부족한 경우 치환이 끝난자리부터만 다시 붙인다 
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