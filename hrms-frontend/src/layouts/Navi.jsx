import React, { useState } from "react";
import { Button, Container, Icon, Menu } from "semantic-ui-react";
import SignedIn from "./SignedIn";
import SignedOut from "./SignedOut";
import { useHistory } from "react-router";
import { Link } from "react-router-dom";

export default function Navi() {

  const [isAuthenticated, setIsAuthenticated] = useState(false)
  const history = useHistory()
  function handleSignOut(props) {
    setIsAuthenticated(false)
    history.push("/")
  }

  function handleSignIn() {
    setIsAuthenticated(true)
  }

  return (
    <div>
          <Menu inverted fixed="top" size="large">
            <Container>
              <Menu.Item>
                <Icon name="react" size="large" />
                Hrms
              </Menu.Item>
              <Menu.Menu position="left">
                <Menu.Item as={Link} to="/">
                  <Icon name="accusoft" />
                  Menü
                </Menu.Item>
                <Menu.Item as={Link} to="/employers">
                  <Icon name="building outline" />
                  Şirketler
                </Menu.Item>
                <Menu.Item>
                  <Icon name="conversation" as={Link} to="/"/>
                  İletişim
                </Menu.Item>
              </Menu.Menu>

              <Menu.Menu position="right">
                <Menu.Item>
                  <Button  as={Link} to="/jobadvertisementform">İş İlanı Ekle</Button>
                </Menu.Item>
                {isAuthenticated ? <SignedIn singOut={handleSignOut} bisey="1"/> 
                : <SignedOut signIn={handleSignIn}/>}
              </Menu.Menu>
            </Container>
          </Menu>
    </div>
  );
}
