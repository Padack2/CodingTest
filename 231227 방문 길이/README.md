## 방문 길이

### 문제 설명
게임 캐릭터를 4가지 명령어를 통해 움직이려 합니다. 명령어는 다음과 같습니다.

U: 위쪽으로 한 칸 가기

D: 아래쪽으로 한 칸 가기

R: 오른쪽으로 한 칸 가기

L: 왼쪽으로 한 칸 가기

캐릭터는 좌표평면의 (0, 0) 위치에서 시작합니다. 좌표평면의 경계는 왼쪽 위(-5, 5), 왼쪽 아래(-5, -5), 오른쪽 위(5, 5), 오른쪽 아래(5, -5)로 이루어져 있습니다.

![image](https://github.com/Padack2/CodingTest/assets/26791213/b8494cc6-7f62-4eb3-a520-6a92d01c273a)


예를 들어, "ULURRDLLU"로 명령했다면

![image](https://github.com/Padack2/CodingTest/assets/26791213/6556d8c2-f5e3-4f69-9c4e-fb2219d56079)

1번 명령어부터 7번 명령어까지 다음과 같이 움직입니다.

![image](https://github.com/Padack2/CodingTest/assets/26791213/11f83c96-7017-4a4b-a717-f61c7884811e)


8번 명령어부터 9번 명령어까지 다음과 같이 움직입니다.

![image](https://github.com/Padack2/CodingTest/assets/26791213/8a7b9a7c-f46f-41ec-a6d7-a78832d4ce3e)


이때, 우리는 게임 캐릭터가 지나간 길 중 캐릭터가 처음 걸어본 길의 길이를 구하려고 합니다. 예를 들어 위의 예시에서 게임 캐릭터가 움직인 길이는 9이지만, 캐릭터가 처음 걸어본 길의 길이는 7이 됩니다. (8, 9번 명령어에서 움직인 길은 2, 3번 명령어에서 이미 거쳐 간 길입니다)

단, 좌표평면의 경계를 넘어가는 명령어는 무시합니다.

예를 들어, "LULLLLLLU"로 명령했다면

![image](https://github.com/Padack2/CodingTest/assets/26791213/b4e0eeef-05fc-43d1-8ff5-72f86a55b355)

1번 명령어부터 6번 명령어대로 움직인 후, 7, 8번 명령어는 무시합니다. 다시 9번 명령어대로 움직입니다.

![image](https://github.com/Padack2/CodingTest/assets/26791213/2d7e4fde-7059-4172-a257-77136804ce04)


이때 캐릭터가 처음 걸어본 길의 길이는 7이 됩니다.

명령어가 매개변수 dirs로 주어질 때, 게임 캐릭터가 처음 걸어본 길의 길이를 구하여 return 하는 solution 함수를 완성해 주세요.

### 제한사항
dirs는 string형으로 주어지며, 'U', 'D', 'R', 'L' 이외에 문자는 주어지지 않습니다.
dirs의 길이는 500 이하의 자연수입니다.

### 입출력 예

dirs|answer
--|--
"ULURRDLLU"|7
"LULLLLLLU"|7

### 입출력 예 설명
입출력 예 #1
문제의 예시와 같습니다.

입출력 예 #2
문제의 예시와 같습니다.
