import { useEffect, useState } from 'react';
import Chat from 'react-simple-chat';
import 'react-simple-chat/src/components/index.css';

const Messenger = ({ location }) => {

    //변수 선언
    const [messages, setMessages] = useState([]);
    const [uuid, setUuid] = useState("");
    const [storeNum, setStoreNum] = useState(location.props && location.props.num);

    //함수 선언
    const getAnswer = (message) => {
        setMessages([...messages, message]); //질문
        const url = `http://localhost:8080/chatbot/chat/message`;
        fetch(url, {method:"POST", body: JSON.stringify({question:message, uuid:uuid}), headers:{"Access-Control-Allow-Origin":"*", "Content-Type":"application/json"} })
            .then((res) => res.json())
            .then((data) => {
                setMessages(messages => [...messages, data]); //답변
            }).catch(() => {
                console.log("에러발생");
            });
    };

    const openChat = () => {
        const url = `http://localhost:8080/chatbot/chat/open`;
        fetch(url, {method:"POST", body: JSON.stringify({storeNum:storeNum}), headers:{"Access-Control-Allow-Origin":"*", "Content-Type":"application/json"}})
            .then((res) => res.json())
            .then((data) => {
                console.log(data.uuid);
                setUuid(data.uuid);
                setMessages(messages => [...messages, data]);
            }).catch(()=>{
                console.log("에러발생");
            })
    };

    useEffect(openChat,[]);

    return (
        <Chat
            title="챗봇 샘플"
            user={{ id: 'chatbot' }}
            messages={messages}
            onSend={question=>getAnswer(question) }
        />
    );
};

export default Messenger;