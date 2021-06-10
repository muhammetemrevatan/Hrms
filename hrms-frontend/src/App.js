import "./App.css";
import "semantic-ui-css/semantic.min.css";
import Navi from "./layouts/Navi";
import Footer from "./layouts/Footer";
import SideBar from "./layouts/Sidebar";
import Dashboard from "./layouts/Dashboard";

function App() {
  return (
    <div className="App">
      <Navi />
      <SideBar/>
      <Dashboard />
      <Footer />
    </div>
  );
}

<Dashboard />
export default App;
