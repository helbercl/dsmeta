import Header from "./componentes/Header";
import NotificationButton from "./componentes/NotificationButton";
import SalesCard from "./componentes/SalesCard";
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

function App() {
  return (
    <>
    <ToastContainer />
      <Header />
      <main>
        <section id="sales">
          <div className="dsmeta-controle-largura-container">
            <SalesCard />
          </div>
        </section>
      </main>
    </>
  );

}

export default App;
