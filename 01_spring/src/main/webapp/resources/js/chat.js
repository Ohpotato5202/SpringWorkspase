(function(){
    const displayChatting = document.querySelector(".display-chatting");

    displayChatting.scrollTop = displayChatting.scrollHeight;
})();

// 1) 메세지 전송기능
document.querySelector("#send").addEventListener("click", function(){
    // 채팅메세지
    var inputChatting = document.querySelector("#inputChatting");

    // 입력하지 않은경우 return
    if(!(inputChatting.value.trim())){ // ""
        alert("뭐라도 입력하세요");
        inputChatting.value = "";
        inputChatting.focus();
        return;
    }

    // 메세지를 전달할 객체 생성
    var chatMessage = {
        message : inputChatting.value,
        chatRoomNo,
        userNo,
        userName
    };

    // 데이터 전달시 js의 객체 형태로는 전달 못함. 
    // [Object object]형태로 전달됨 -> json형태로 파싱해서 보내기
    var jsonParsedMessage = JSON.stringify(chatMessage); // json형변환 완료

    // send(값) : 웹소켓 핸들러로 값을 보내는 역할을 한다.
    chattingSocket.send(jsonParsedMessage);

    // 메세지 보낸 후 지워주기
    inputChatting.value = "";
});


// 2) 메세지 응답기능
//  -> 서버 웹소켓 핸들러에서 sendMessage하는 구문을 감지하는 이벤트 핸들러(onmessage)
chattingSocket.onmessage = function(e){
    console.log(e.data); // json형태의 데이터

    // 전달받은 메세지(json)를 js객체로 변환
    var chatMessage = JSON.parse(e.data);
    console.log(chatMessage); // js객체

    var li = document.createElement("li");

    var p = document.createElement("p");
    p.classList.add("chat");
    p.innerHTML = chatMessage.message.replace(/\\n/gm, "<br>");
    // <p class="chat">ㄴㅇㄹ<br>ㄴㅇㅁㄹ</p>

    var span = document.createElement("span");
    span.classList.add("chatDate");
    span.innerText = currentTime();

    // 내가쓴 글인지 아닌지 체크
    if(userNo == chatMessage.userNo){ // 내가쓴 글
        li.classList.add("myChat");
        li.append(span, p);
    }else{ // 남이쓴 글
        li.innerHTML = `<b>${chatMessage.userName}</b>`;
        li.append(p, span);
    }

    // 채팅창 요소 가져오기
    const displayChatting = document.querySelector(".display-chatting");

    // 채팅창에 내용 추가
    displayChatting.append(li);

    // scrollTop : 스크롤바의 위치
    // scrollHeight : 스크롤 되는 요소의 전체 크기
    displayChatting.scrollTop = displayChatting.scrollHeight;

}

function currentTime(){
    var now = new Date();
    return `${now.getFullYear()}-${now.getMonth()+1 < 10 ? '0'+ (now.getMonth()+1) : (now.getMonth()+1)}-${now.getDate() < 10 ? '0' + now.getDate() : now.getDate()} `; // 2024-06-21
}

var exitBtn = document.querySelector("#exit-btn");
exitBtn.onclick = function(){
    location.href = `${contextPath}/chat/chatRoom/${chatRoomNo}/exit`;
};
