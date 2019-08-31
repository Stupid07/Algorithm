import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(String[] lines) {
        int answer = 0;
        double second = 0;
	    String[] words;
	    MyTime startTime, endTime;
	    ArrayList<MyTime> list = new ArrayList<>(lines.length<<1);
	    for(int i = 0, size=lines.length; i < size; i++){
            words = lines[i].split(" ");
	        startTime = new MyTime(words[1]);
	        endTime = new MyTime(words[1], true);
	        second = Double.parseDouble(words[2].substring(0, words[2].length()-1));
	        second -= 0.001;
	        startTime.minusSeconds(second);
	        endTime.plusSeconds(0.999);
	        list.add(startTime);
	        list.add(endTime);
        }
	    Collections.sort(list);
	    int maxProcess = 0, currentProcess = 0;
	    for(MyTime data : list) {
            if(data.isEndTime) {
                currentProcess--;
	    	}else {
	    		  currentProcess++;
	    		  if(maxProcess < currentProcess) {
	    			  maxProcess = currentProcess;
	    		  }
	    	  }
	      }
	      answer = maxProcess;
	      return answer;
  }
    
}

class MyTime implements Comparable<MyTime>{
		int hour;
		int minute;
		double second;
		boolean isEndTime;
		
		public MyTime(String time) {
			String[] times = time.split(":");
			this.hour = Integer.parseInt(times[0]);
			this.minute = Integer.parseInt(times[1]);
			this.second = Double.parseDouble(times[2]);
			this.isEndTime = false;
		}
		
		public MyTime(String time, boolean isEndTime) {
			this(time);
			this.isEndTime = isEndTime;
		}
		
		public void minusSeconds(double seconds) {
			this.second -= seconds;
			if(this.second < 0) {
				minute--;
				this.second += 60.0;
				if(this.minute < 0) {
					this.hour--; // hour은 -1까지 가능
					this.minute += 60;
				}
			}
		}
		
		public void plusSeconds(double seconds) {
			this.second += seconds;
			if(this.second > 60.0) {
				minute++;
				this.second -= 60.0;
				if(this.minute > 60) {
					this.hour++; // hour은 25까지 가능
					this.minute -= 60;
				}
			}
		}
		
		@Override
		public int compareTo(MyTime o) {
			if(this.hour > o.hour) {
				return 1;
			}else if(this.hour < o.hour) {
				return -1;
			}else {
				if(this.minute > o.minute) {
					return 1;
				}else if(this.minute < o.minute) {
					return -1;
				}else {
					if(this.second > o.second) {
						return 1;
					}else if(this.second < o.second) {
						return -1;
					}else {
						if(this.isEndTime) {
							return 1;
						}else if(o.isEndTime) {
							return -1;
						}else {
							return 0;
						}
					}
				}
			}
		}
		
		@Override
		public String toString() {
			return String.format("%02d:%02d:%05.3f %s", hour, minute, second, isEndTime ? "END": "START");
		}
		
}