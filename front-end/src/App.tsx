import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { Provider } from "react-redux";
import { Switch, Route, Router } from "react-router";
import "./App.css";
import "./css/Main.css";
import { store } from "./Store";
import LoginComponent from "./components/login-component/LoginContainer";
import CreatePostComponent from "./components/create-post-component/CreatePostComponent";
import CreateUserComponent from "./components/create-user-component/CreateUserContainer";
import { MainPageComponent } from "./components/main-page-component/MainPageComponent";
import { history } from "./utility/history";
import { EmailComponent } from "./components/email-component/EmailComponent"

const App: React.FC = () => {
  return (
    <div className="App">
      <Provider store={store}>
        <Router history={history}>
          <Switch>
            <Route path="/home" component={MainPageComponent} />
            <Route path="/post" component={CreatePostComponent} />
            <Route path="/login" component={LoginComponent} />
            <Route path="/register" component={CreateUserComponent} />
            <Route path="/email" component={EmailComponent}/>
            <Route path="/" component={MainPageComponent} />
          </Switch>
        </Router>
      </Provider>
    </div>
  );
};

export default App;
