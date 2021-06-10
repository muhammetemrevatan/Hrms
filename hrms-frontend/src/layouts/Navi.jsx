import React, { useState } from "react";
import { Button, Container, Icon, Menu, Segment } from "semantic-ui-react";
import SignedIn from "./SignedIn";
import SignedOut from "./SignedOut";
import { useHistory } from "react-router";

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
      <Segment.Group>
        <Segment inverted>
          <Menu inverted fixed="top" size="large">
            <Container>
              <Menu.Item>
                <Icon name="react" size="large" />
                Hrms
              </Menu.Item>
              <Menu.Menu position="left">
                <Menu.Item>
                  <Icon name="accusoft" />
                  Menu
                </Menu.Item>
                <Menu.Item>
                  <Icon name="building outline" />
                  Companies
                </Menu.Item>
                <Menu.Item>
                  <Icon name="conversation" />
                  Contact
                </Menu.Item>
              </Menu.Menu>

              <Menu.Menu position="right">
                <Menu.Item>
                  <Button inverted>Job Advertisement List</Button>
                </Menu.Item>
                {isAuthenticated ? <SignedIn singOut={handleSignOut} bisey="1"/> 
                : <SignedOut signIn={handleSignIn}/>}
              </Menu.Menu>
            </Container>
          </Menu>
        </Segment>
      </Segment.Group>
    </div>
  );
}
