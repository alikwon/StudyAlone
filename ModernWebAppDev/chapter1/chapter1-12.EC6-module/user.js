/**
 *  - ES6에서 JS 는 모듈을 지원함
 *  - import 와 export는 최상위에 위치해야함
 *  - <script type="module"> 로 모듈파일을 브라우저로 불러올 수도 있다
 */


/*
    ● Export
        - 두가지 유형
            - 명명된 내보내기 named export
            - 기본 내보내기  default export    
        - 하나의 모듈에는 하나의 기본내보내기만    */

export default class User{
    constructor(name,role){
        this.name = name;
        this.role = role;
    }
}

