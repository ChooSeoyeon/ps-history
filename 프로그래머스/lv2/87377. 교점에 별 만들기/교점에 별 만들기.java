/*
[설명]
- Ax+By+C=0 꼴의 n개의 직선 주어짐
- 직선의 교점 중 정수 좌표에 도형을 그림
- (4,1) (4,-4) (-4, -4) (-4,1) (0,4)
- 가장 작은 크기의 도형을 담는 사각형을 반환
- A, B, C가 담긴 배열 line
[접근] 배열
- a*d-b*c=0 인지 확인 후 거르기(평행 또는 일치)
- 거른 후에 교점 찾기 
- Ax + By + E = 0 -> A = line[i][0], B = line[i][1], E = line[i][2]
- Cx + Dy + F = 0 -> C = line[j][0], D = line[j][1], F = line[j][2]
- x = (b*f-e*d)/(a*d-b*c)
- y = (e*c-a*f)/(a*d-b*c)
- (4,1) (4,-4) (-4, -4) (-4,1) (0,4)  -> 9, 9
*/
import java.util.*;

class Solution {
    static long maxX = Long.MIN_VALUE;
    static long minX = Long.MAX_VALUE;
    static long maxY = Long.MIN_VALUE;
    static long minY = Long.MAX_VALUE;
    
    class Point{
        long x, y;
        public Point(long x, long y) {
            this.x=x;
            this.y=y;
        }
    }
    
    public String[] solution(int[][] line) {
        String[] answer = {};
        HashSet<Point> coordinates = new HashSet<Point>();
        
        for(int i = 0; i < line.length-1; i++) {
            for(int j = i + 1; j < line.length; j++) {
                long a = line[i][0]; long b = line[i][1]; long e = line[i][2];
                long c = line[j][0]; long d = line[j][1]; long f = line[j][2];
                
                if((a*d-b*c) == 0) continue;
                if((b*f-e*d) % (a*d-b*c) != 0) continue;
                if((e*c-a*f) % (a*d-b*c) != 0) continue;
                
                long x = (b*f-e*d) / (a*d-b*c);
                long y = (e*c-a*f) / (a*d-b*c);

                coordinates.add(new Point(x, y)); // 중복 제거 안됨. new라서.
                
                maxX = Math.max(maxX, x);
                minX = Math.min(minX, x);
                maxY = Math.max(maxY, y);
                minY = Math.min(minY, y);
            }
        }
        
        long width = maxX - minX + 1;
        long height = maxY - minY + 1;
        
        answer = new String[(int)height];
        
        String oneLine = "";
        for(int i=0; i<width; i++) {
            oneLine += ".";
        }
        for(int i=0; i<height; i++) {
            answer[i] = oneLine;
        }
        for(Point point : coordinates) {
            int starX = (int)point.x - (int)minX;
            int starY = (int)maxY - (int)point.y;
            answer[starY] = answer[starY].substring(0, starX) + '*' + answer[starY].substring(starX+1);
        }
        
        return answer;
    }
}