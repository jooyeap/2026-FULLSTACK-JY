package com.the703.basic008_ex;

import java.util.Arrays;

public class Array3Total_Answer {

    public static void main(String[] args) {
        String[] name = {"아이언맨","헐크","캡틴","토르","호크아이"};
        int[] kor = {100,100,90,70,35};   
        int[] eng = {100,100,95,80,35};
        int[] mat = {100,100,90,60,35};
        
        int[] aver = new int[name.length];
        String[] hap = new String[name.length];
        String[] jang = new String[name.length];
        int[] rank = new int[name.length];

        // 1. 평균, 합격여부, 장학생 여부 계산
        for(int i=0; i<name.length; i++) {
            aver[i] = (kor[i] + eng[i] + mat[i]) / 3;
            hap[i] = aver[i] >= 60 ? "합격" : "불합격";
            jang[i] = aver[i] >= 95 ? "장학생" : "----";
        }

        // 2. 등수 계산 (동점자 동일 등수, 다음은 이어서 증가)
        // 평균과 인덱스를 함께 저장
        // integer << 말하기가 애매한데 인덱스같이 오름차 내림차로 순서 저장할때? 그럴때만 사용한다는거같음
        Integer[] idx = new Integer[name.length];
        for(int i=0; i<idx.length; i++) idx[i] = i;

        // 내림차순 정렬
        // 람다식 (배열이름 , 비교대상(허상값?) -> b - a (오름차) a - b (내림차) 
        Arrays.sort(idx, (a,b) -> aver[b] - aver[a]);

        int currentRank = 1;
        rank[idx[0]] = currentRank;
        
        // 이미 오름차로 순서를 배열을 다했으니 비교대상 앞이나 뒤에 하나만 비교
        for(int i=1; i<idx.length; i++) {
            if(aver[idx[i]] == aver[idx[i-1]]) { // 같은등수면 등수 올라가지않게 처리하고
                // 동점자 → 같은 등수
                rank[idx[i]] = currentRank;
            } else {							// 다른등수면 등수 대입전에 증가시킨뒤 대입
                // 새로운 점수 → 등수 증가
                currentRank++;
                rank[idx[i]] = currentRank;
            }
        }

        // 3. 출력
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("이름\t국어\t영어\t수학\t평균\t등수\t합격여부\t장학생\t랭킹");
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

        for(int i=0; i<name.length; i++) {
            System.out.printf("%s\t%d\t%d\t%d\t%d\t%d등\t%s\t%s\t",
                name[i], kor[i], eng[i], mat[i], aver[i], rank[i], hap[i], jang[i]);
            for(int j=0; j<(aver[i]/10); j++) {
                System.out.print("★");
            }
            System.out.println();
        }
    }
}
