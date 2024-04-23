import toast, { Toaster } from "react-hot-toast";
import Login from "./components/Login";
import { Route, Routes } from "react-router-dom";
import Home from "./components/Home";

function App() {
  return (
    <div className="h-full">
      <Routes>
        <Route path="/login" element={<Login></Login>} />
        <Route path="/home" element={<Home></Home>} />
      </Routes>
      <Toaster />
    </div>
  );
}

export default App;
