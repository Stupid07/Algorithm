public class Test {
    long sum(int[] a) {
        long ans = 0;
        for(int i = 0,size = a.length; i < size; i++){
			ans += a[i];
		}
        return ans;
    }
}
