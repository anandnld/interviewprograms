package mylearning;

public class ConnectingSticks {

	public static void main(String[] args) {
		
		ConnectingSticks obj = new ConnectingSticks();
		int[] sticks = new int[] {1,8,3,5};// {2,4,3};
		int cost = obj.connectSticks(sticks);
		System.out.println("COST : "+cost);
	}
		
	public int connectSticks(int[] sticks) {
		
		int cost = 0;
		if(sticks == null || sticks.length == 0) {
			return cost;
		}
		
		for(int i=0;i<sticks.length;i++) {
			for(int j=i+1;j<sticks.length;j++) {
				if(sticks[i] > sticks[j]) {
					int tmp = sticks[i];
					sticks[i] = sticks[j];
					sticks[j] = tmp;
				}
			}
		}
		
		int tmp = sticks[0];
		for(int i=1;i<sticks.length;i++) {
			tmp = sticks[i] + tmp;
			cost = cost + tmp;
		}
		
		return cost;
	}
}
