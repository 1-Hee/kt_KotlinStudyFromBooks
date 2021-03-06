package `86_ex_extenstion_function`

//chaop 86. 확장함수
// String은 코틀린에 내장된 클래스이기 때문에 우리가 마음대로 멤버함수를 추가할 수 없다.
// 그렇다고 String 클래스를 상속하자니, open 키워드가 붙어있지 않아 불가능하다.
// 확장함수라는 문법을 이용하면 상속 없이 클래스 외부에서 멤버 함수를 추가할 수 있다.

// 문자열이 숫자로만 이루어져있는지 판단하는 확장 함수
fun String.isNumber():Boolean // 확장함수를 선언하는 것은 간단하다. 함수이름 앞에 '주입할 클래스.'를 붙여주면 된다. 여기서  '함수를 주입할 클래스'를 리시버(Reciever)타입이라고 부른다
{
    var i = 0
    while (i<this.length) // this를 사용하면 리시버 타입의 프로퍼티나 멤버함수에 접근할 수 있다. 단, private이거나 protected인 멤버에는 접근할 수 없다.
    // length는 문자열의 길이, 즉 문자열에 포함된 문자의 개 수를 갖고 있는 String 클래스의 프로퍼티이다.
    {
        //숫자가 아닌 문자가 하나라도 들어 있으면 false 변환
        if(!('0' <= this[i] && this[i] <= '9')) // 숫자는 유니코드에 '0'..'9' 순으로 정의되어 있는데, <= 연산자를 이용하여 문자열의 i번째 문자가 숫자 문자 범위 안에 있는지 검사했다.
            return false
        i += 1
    }
    // 모든 조건을 통과하면 true 반환
    return true
}

fun main(args:Array<String>)
{
    println("1234567890".isNumber()) // isNumber 확장 함수는 마치 String의 멤버함수인 것처럼 호출할 수 있다. 확장 함수는 멤버함수와의 구분을 위해 색상이 강조된다.
    println("500원".isNumber())
}
// 만약, 클래스에 이미 존재하는 멤버 함수와 동일한 시그니처의 확장 함수가 있으면 어떻게 될까?
// 오류는 나지 않지만, 확장 함수가 가려진다. 즉 함수 호출 시 멤버함수만 항상 호출 된다.