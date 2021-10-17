//import { Link } from "react-router-dom";
import Button from '@mui/material/Button';
import { useHistory } from "react-router-dom";

const Main = () => {

        const history = useHistory();
    //함수
    const selectStore = (num) => {
        history.push({
            pathname:"/vchat",
            props: { num:num }
        })
    };

    return(
        
        <div className="chat">
            <h1 style={{fontSize:'8em'}}>메인화면 입니다.</h1>
            <Button variant="contained" onClick={()=>selectStore(1)}>서울지점</Button>
            <Button variant="contained" onClick={()=>selectStore(2)}>경기지점</Button>
        </div>
       
    );
};

export default Main;

/*
            <Link to="/chat">
                <button>채팅 화면으로 이동</button>
            </Link>
*/