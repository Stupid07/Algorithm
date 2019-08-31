import java.util.*;

class Solution {
  public int solution(int cacheSize, String[] cities) {
      if(cacheSize == 0){
          return cities.length * 5;
      }
      
      int answer = 0;
      LinkedList<String> list = new LinkedList<>();
      String city;
      for(String beforeProcessCity : cities){
          city = beforeProcessCity.toLowerCase();
          if(list.contains(city)){
              answer++;
              list.remove(city);
          }else{
              answer+=5;
              if(list.size() == cacheSize){
                  list.poll();
              }
          }
          list.add(city);
      }
      return answer;
  }
}