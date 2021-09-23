import { Link } from "react-router-dom";

const Main = () => {

    return(
        <div>
            <h1>메인화면 입니다.</h1>
            <Link to="/chat">
                <button>채팅 화면으로 이동</button>
            </Link>
        </div>
    );
};

export default Main;