class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashMap<Integer,Set<Integer>> map=new HashMap<>();
        int m=obstacles.length;
        for(int i=0;i<m;i++){
            if(!map.containsKey(obstacles[i][0])){
                map.put(obstacles[i][0],new HashSet<>());
            }
            map.get(obstacles[i][0]).add(obstacles[i][1]);
        }
        int x=0;
        int y=0;
        int res=-1;
        // 0-North, 1-South, 2-East, 3-West
        int dir=0;
        int n=commands.length;
        for(int i=0;i<n;i++){
            if(commands[i]==-1){
                if(dir==0) dir=2;
                else if(dir==1) dir=3;
                else if(dir==2) dir=1;
                else dir=0;
                continue;
            }
            else if(commands[i]==-2){
                if(dir==0) dir=3;
                else if(dir==1) dir=2;
                else if(dir==2) dir=0;
                else dir=1;
                continue;
            }
            if(dir==0){
                for(int j=0;j<commands[i];j++){
                    if(map.containsKey(x) && map.get(x).contains(y+1)){
                        break;
                    }
                    y++;
                }
            }
            else if(dir==1){
                for(int j=0;j<commands[i];j++){
                    if(map.containsKey(x) && map.get(x).contains(y-1)){
                        break;
                    }
                    y--;
                }
            }
            else if(dir==2){
                for(int j=0;j<commands[i];j++){
                    if(map.containsKey(x+1) && map.get(x+1).contains(y)){
                        break;
                    }
                    x++;
                }
            }
            else{
                for(int j=0;j<commands[i];j++){
                    if(map.containsKey(x-1) && map.get(x-1).contains(y)){
                        break;
                    }
                    x--;
                }
            }
            res=Math.max(res,((x*x)+(y*y)));
        }
        return res;
    }
}