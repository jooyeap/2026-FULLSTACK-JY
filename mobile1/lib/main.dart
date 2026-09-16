import 'package:flutter/material.dart';

// 1. 실행점
void main() {
  runApp(
    MaterialApp(
      home: Scaffold(
        appBar: AppBar( title: Text('첫 Flutter 앱')),
        body: Center( child: Text('Hello Flutter 123123'),),
      ),
    ),
  );
}

// Scaffold : 전체 기본 뼈대 - 상단바, 본문 제공하는 기본 위젯
// appBar : 상단 타이틀바
// body : 몸통 구성