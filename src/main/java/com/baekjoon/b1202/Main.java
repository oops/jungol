package com.baekjoon.b1202;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static long[] vm ;
    public static long VMDUMMY = 10000000L;
    public static int N;
    public static int K;
    public static TreeSet<Integer>  ts = new TreeSet<Integer>();
    public static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public static void main(String... arg) throws Exception{

        FileInputStream in = new FileInputStream("D:\\source\\jungol\\src\\main\\java\\com\\baekjoon\\b1202\\input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st ;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        vm = new long[N];

        int localm ;
        int localv ;

        // 보석의 가치와 무게 저장.
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            localm = Integer.parseInt(st.nextToken());
            localv = Integer.parseInt(st.nextToken());
            vm[i] = localv * VMDUMMY + localm;
        }

        // 가치 우선 정렬. ( 같은 가치일 때 무게가 많은 것부터 나오네요.. 적은것부터 하는 것이 어떨까하는 생각은 있음. )
        Arrays.sort(vm);

        // 가방 무게를 treeset에 넣고 동일 무게 가방의 개수를 map에 저장
        Integer bagCapacity ;
        for (int i = 0; i < K; i++) {
            bagCapacity = Integer.parseInt(br.readLine());
            if( ts.contains(bagCapacity)) {
                map.put(bagCapacity, map.get(bagCapacity) + 1 );
            } else {
                ts.add(bagCapacity);
                map.put(bagCapacity, 1);
            }
        }
        long sum = 0L;

        // 가치가 높은 보석부터 그 무게를 감당할 수 있는 가장 작은 가방에 차례로 넣고
        // 해당 가방을 하나씩 뺀다. 개수를 빼거나(map) 아예 그 가방 존재 자체를 제거(treeset)
        for (int i = N-1; i >= 0; i--) {
            // 보석을 넣을 수 있는 가장 작은 가방 선택
            bagCapacity = ts.ceiling((int)(vm[i] % VMDUMMY));
            // 넣을 수 있는 가방이 있다면
            if( bagCapacity != null ) {
                if( map.get(bagCapacity) > 1 ) {
                    map.put(bagCapacity, map.get(bagCapacity)-1);
                } else {
                    ts.remove(bagCapacity);
                }
                sum += (int)(vm[i] / VMDUMMY);
            }
        }
        System.out.println(sum);
    }
}
