package com.oops;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sosiji {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] length = new int[n];
		int[] width = new int[n];
		List indexList = new ArrayList();
		
		for(int i=0;i<n;i++){
			length[i]=sc.nextInt();
			width[i]=sc.nextInt();
			indexList.add(i);
		}
		//�ʱ�����. 1.���� 2.�ʺ�
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				if(length[i] > length[j]){
					int temp=length[i];
					length[i]=length[j];
					length[j]=temp;
					int temp2=width[i];
					width[i]=width[j];
					width[j]=temp2;
				}else if(length[i]==length[j]){
					if(width[i] > width[j]){
						int temp=length[i];
						length[i]=length[j];
						length[j]=temp;
						int temp2=width[i];
						width[i]=width[j];
						width[j]=temp2;
					}
				}
			}
		}
		int size = indexList.size();
		int totalCount = 0;
		while(size > 0){
			indexList = loop(width,indexList);
			totalCount++;
			size = indexList.size();
		}
		System.out.println(totalCount);
	}
	public static List loop(int[] width, List<Integer> indexList){
		int previous = 0;
		int index = 0;
		
		List result = new ArrayList();
		previous = width[indexList.get(0)];
		
		for(int i=0; i< indexList.size()-1; i++){
			
			if(previous > width[indexList.get(i+1)] ){
				result.add(indexList.get(i+1));
			}else{
				previous = width[indexList.get(i+1)];
			}
		}
		return result;
	}
}
