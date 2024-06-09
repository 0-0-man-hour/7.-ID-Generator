# ID-Generator 관련 내용

7장 ID 생성기 관련 내용입니다.
notion: https://www.notion.so/7-ID-57bc5ecd72fd43e1889c38204f66299a?pvs=4

담당자: 이태혁(taehyuk Lee)  

|Week|Date|Desc|
|------|---|---|
|1주차|24.05.19~|내용 정리 및 설계|
|2주차|24.05.26~|ID 생성기 구현완료, 테스트 서버 구성 및 테스트 시나리오 확립|
|3주차|24.06.02~|트래픽 발생 테스터기를 통한 성능테스트 및 ID확인|

- 1주차. ID 생성기 구현 완료 테스트 시나리오 확립
- 2주차. 트래픽 발생 테스트 성능테스트 및 튜닝 

### 상세 설계  
- 구현 1주차: 주 내용중 하나는 자바에서 bit연산 하는 방법과 String 형태와 bit사이의 전환을 주로 다루고 있다.
  - 그리고 Id Generator를 만들고 Library화 하는것까지가 일단 ID생성기 구현의 목표이다.
 
- 성능 테스트 도구를 이용해서 각 Application에 10,000 TPS이상의 트래픽을 발생시켜 본다.
  - 이에 대한 이미지는 다음과 같다.

    <img width="954" alt="image" src="https://github.com/0-0-man-hour/7.ID-Generator/assets/89365465/e41e4553-02ac-4f5d-92c0-a95409156dea" width=350 height=500>
    </img>
     

### 주요 기능


### API
- 다음과 같이 main method에 ```SnowFlakeIdGen.jar```를 dependency로 받아와서 ```generateNewId(serverId, dataCenterId)``` method를 사용하면 새로운 Id를 받아올수 있다.

  ``` java
  public static void main(String[] args) throws Exception {
    
    SnowFlakeIdGen idGen = new SnowFlakeIdGen();
    
    long serverId = 1L;
    long dataCenterId = 1L;

    //generate Id
    long newId = idGen.generateNewId(serverId, dataCenterId);
        
        
        System.out.println(newId);
       
  }
  ```

### Test 

- Nexus 구성 및 hosted Repository에 jar upload
  
  <p align="center"> <img width="800" alt="image" src="https://github.com/0-0-man-hour/7.ID-Generator/assets/89365465/d09378a8-53e2-432f-bce4-d86685586747" height=450>
    </img> </p>


- Netty Application에 Snow-Flake-Id-Geneartor 연결 (<b>단, Nexus에 올려서 직접 받아오는건 실패</b>)
  <p align="center"> <img width="350" alt="image" src="https://github.com/0-0-man-hour/7.ID-Generator/assets/89365465/eaddfa87-19b9-45d7-ae8a-1c5bfe0757c4" height=250>
    </img> </p>
  1. 이후 위 application을 jar로 묶어서 각 1, 2서버에 배포
  2. Macbook으로 Apach bench 수행



### 사용방법
- SnowFlakeIdGen.java를 library화할 예정이다 이걸 new연산자로 새로 만들어서 그 안에 generateNewId(serverId, dataCenterId); 만 넣으면 이에 해당하는 Id가 발생한다.


### 특이사항
- 자바에서 String이나 Object Type사용은 최대한 지양하려고 했다. 대용량이고 애시당초 SnowFlake기법 자체가 bit기반으로 되어 있기때문에 bit연산자를 이용해서 연산함.
- 성능 테스트 도구 <a href="https://www.lesstif.com/software-architect/wrk-modern-http-bench-marking-tool-106856711.html"> 성능테스트 도구 링크 </a>

