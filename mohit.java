class test{
	public static void main(String[] args){
		int[] arr= {2,0,4,4};
		int i;
		int j;
		for(i=0;i<=2;i++){
			for(j=i+1;j<=3;j++){
				if(arr[j]==0){
					continue;
				}
				if (arr[i]!=arr[j]){
					break;
				}
				else if(arr[i]==arr[j]){
					arr[i]=arr[i]+arr[j];
					arr[j]=0;
					break;
				}
				
			}
		}

		for(i=0;i<=3;i++){
			if(arr[i]!=0){
				for(j=i;j>0;j--){
					if(arr[j-1]==0){
						arr[j-1]=arr[j];
						arr[j]=0;
					}
				}
			}
		}
		for(i=0;i<=3;i++){
			System.out.print(arr[i]+" ");
		}

	}
}