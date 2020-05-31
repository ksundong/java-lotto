# 문자열 덧셈 계산기

## 기능 요구사항

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

## 프로그래밍 요구사항

- indent(들여쓰기) depth를 2단계에서 1단계로 줄여라.
- 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
- else를 사용하지 마라.

## Todo List

- Splitter
    - [X] 쉼표(,) 구분자로 문자열을 분리할 수 있다.
    - [X] 콜론(:) 구분자로 문자열을 분리할 수 있다.
    - [X] 쉼표(,), 콜론(:) 구분자로 문자열을 분리할 수 있다.
    - [X] 커스텀 구분로 문자열을 분리할 수 있다.
- Number 
    - [X] 음수 값이 전달되는 경우 RuntiemException 예외를 throw 할 수 있다.    
- StringCalculator
    - [X] 문자열 숫자의 합을 구할 수 있다.
- Main
    - [X] 숫자 이외의 값이 전달되는 경우 RuntiemException 예외를 throw 할 수 있다.
    - [X] 빈 문자열 또는 null 값을 입력할 경우 0을 반환할 수 있따.