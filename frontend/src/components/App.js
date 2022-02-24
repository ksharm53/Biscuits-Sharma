import {
  BrowserRouter as Router,
  Route,
  Link,
  Routes
} from "react-router-dom";

import Home from '../pages/Home';
import CreateNewProject from '../pages/CreateNewProject';

function App() {
  return (
    <div className="App">
      
      <h1>Project</h1>

      <Router>
            <div>
              <nav>
                <ul>
                  <li>
                    <Link to="/">Home</Link>
                  </li>
                  <li>
                    <Link to="/create-new-project">Create New Project</Link>
                  </li>
                </ul>
              </nav>

              <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/create-new-project" element={<CreateNewProject />} />
              </Routes>
            </div>
          </Router>
    </div>
  );
}

export default App;
