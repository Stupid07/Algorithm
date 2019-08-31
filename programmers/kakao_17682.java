class Solution {
    public int solution(String dartResult) {
          int answer = 0;
          final int MAX_NUMBER = 3;
          final char DOUBLE = 'D', TRIPLE = 'T', STAR = '*', OOPS = '#';
          String[] stringNumbers = dartResult.split("[SDT*#]+");
          String[] options = dartResult.split("\\d+");
          int[] numbers = new int[MAX_NUMBER];
          for(int i = 0; i < MAX_NUMBER; i++) {
              numbers[i] = Integer.parseInt(stringNumbers[i]);
              switch(options[i+1].charAt(0)) {
                  case DOUBLE:
                      numbers[i] *= numbers[i];
                      break;
                  case TRIPLE:
                      numbers[i] *= numbers[i] * numbers[i];
                      break;
              }
              
              if(options[i+1].length() > 1) {
                  switch(options[i+1].charAt(1)) {
                      case STAR:
                          if(i > 0) {
                              numbers[i-1] *= 2;
                          }
                          numbers[i] *= 2;
                          break;
                      case OOPS:
                          numbers[i] *= -1;
                          break;
                  }
              }
          }
          
          for(int i = 0 ; i < MAX_NUMBER; i++) {
              answer += numbers[i];
          }
          return answer;
      }
  }