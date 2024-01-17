
public class Programmers_250137 {

	public int main(int[] bandage, int health, int[][] attacks) {
        int answer = health;          // 체력 초기화
        int cnt = 0;                  // 연속 성공 카운터 
        int length = attacks.length;
        int t = attacks[length-1][0]; // 마지막 공격 시간 = t 
        int dmg;
        
        // 공격 판단 시작
        for (int i = 0; i <= t; i++) {
            dmg = 0;
            for (int j = 0; j < length; j++) {
                if (i == attacks[j][0]) {
                    dmg = attacks[j][1];
                    break;
                }
            }
            if (dmg > 0) {
                cnt = 0;
                answer -= dmg;
            } else {
                cnt++;
                answer += bandage[1];
            }
            
            if (answer <= 0) {
                return -1;
            } else if (cnt == bandage[0]) {
                cnt = 0;
                answer += bandage[2];
            }
            
            if (answer > health) {
                answer = health;
            }
        }
        return answer;
	}
}