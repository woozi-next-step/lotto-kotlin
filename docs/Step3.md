# 3단계 - 로또(2등)  

* 2등을 위해 추가 번호를 하나 더 추첨한다.
* 당첨 통계에 2등도 추가해야 한다.

# 설계
## 생각

1. 보너스볼을 입력받는다.  
2. 맞은 갯수 + 보너스볼을 맞았는지 여부를 통해 matchBoard 에서 알맞는 enum을 받는다.
  * 참고로 이넘에 true/false 필드를 추가할까 생각했는데, 나머지 필드들에 불필요한 값 들어온다는 생각듬
  * 결과적으로 메서드를 통해서 boolean 값 받고 판단하는게 나을 것 같다.
   
## 클래스 
> Step2 와 중복되는 클래스는 입력 X 

* [x] WinningLotto   
    * Lotto -> 당첨 로또 
    * LottoNumber -> 보너스 로또 
        * 둘을 한번에 입력받아서, 중복 없는지 검증 + 보너스 볼 사용 여부 역할 부여  
        * 상속 대신 컴포지션!! 방식이라고 생각해도 좋다.  
    * 기능:  
        * 다른 로또를 인자로 받아서 맞은 갯수 반환  
        * 다른 로또를 인자로 받아서 보너스 여부 반환
      
# 추가  
* 보너스볼이 필요하지 않다면? -> 전부다 하나의 값으로 통일 -> false  
* 보너스볼이 필요하다면? -> 들어온 값, 그대로 내보내면 되지 않나? -> true/false 가지고 알아서 계산할 듯