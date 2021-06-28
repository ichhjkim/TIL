class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int min_num = 1;
        for (int i=0;i<stations.length;i++) {
            
            int station = stations[i];
            
            int limit_num = station-w;
            
            int top_num = limit_num-min_num;
            int under_num = (2*w)+1;
            
            answer += (int)top_num/under_num;
            
            if ((top_num%under_num) > 0) {
                answer += 1;
            }
            min_num = station+w+1;
            
            if (i==stations.length-1 && min_num<=n) {

                int left = n-min_num+1;
                if (left%under_num==0) {
                    answer += (int)left/under_num;
                } else {
                    answer += (int)left/under_num+1;
                }
            }
        }
        
        return answer;
    }
}