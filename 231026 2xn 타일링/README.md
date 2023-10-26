## 2 x n 타일링

### 문제 설명

가로 길이가 2이고 세로의 길이가 1인 직사각형모양의 타일이 있습니다. 이 직사각형 타일을 이용하여 세로의 길이가 2이고 가로의 길이가 n인 바닥을 가득 채우려고 합니다. 타일을 채울 때는 다음과 같이 2가지 방법이 있습니다.

타일을 가로로 배치 하는 경우
타일을 세로로 배치 하는 경우
예를들어서 n이 7인 직사각형은 다음과 같이 채울 수 있습니다.

![image](https://github.com/Padack2/CodingTest/assets/26791213/98df6485-483e-4ced-bc22-4f232c9f7f82)


직사각형의 가로의 길이 n이 매개변수로 주어질 때, 이 직사각형을 채우는 방법의 수를 return 하는 solution 함수를 완성해주세요.

### 제한사항

가로의 길이 n은 60,000이하의 자연수 입니다.
경우의 수가 많아 질 수 있으므로, 경우의 수를 1,000,000,007으로 나눈 나머지를 return해주세요.

### 입출력 예

|n|result|
|---|---|
|4|5|

### 입출력 예 설명

입출력 예 #1
다음과 같이 5가지 방법이 있다.

![image](https://github.com/Padack2/CodingTest/assets/26791213/a5aae644-dc99-4aae-808b-af67edd57239)
![image](https://github.com/Padack2/CodingTest/assets/26791213/c51b3fae-f02b-471b-8c3d-3c1a6d00dabb)
![image](https://github.com/Padack2/CodingTest/assets/26791213/fc6ce2a2-7e77-4898-8fb1-6cc1d8887b30)
![image](https://github.com/Padack2/CodingTest/assets/26791213/1da2c13b-8884-4168-8cdd-eb8735303d81)
![image](https://github.com/Padack2/CodingTest/assets/26791213/f4b8842f-f9cd-418e-a612-957e7d0b508a)

