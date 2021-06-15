import React from "react";
import { Button, Menu } from "semantic-ui-react";

export default function SignedOut({ signIn },{ clickedd}) {
    
  return (
    <div>
      <Menu.Item>
        <Button.Group>
          <Button onClick={signIn}>Giriş Yap</Button>
          <Button.Or />
          <Button positive onClick={clickedd}>Kayıt Ol</Button>
        </Button.Group>
      </Menu.Item>
    </div>
  );
}
