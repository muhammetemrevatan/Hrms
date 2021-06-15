import React from "react";
import { Link } from "react-router-dom";
import { Menu, Icon} from "semantic-ui-react";

export default function SideBar() {
  
  return (
    <div>
      <Menu  vertical style={{ margin: "2em 2em 1em 0em"}}>
        <Menu.Item style={{ margin: "2em 2em 1em 0em", padding: "2em 0em 1em 2em"}}>
          <Link to="/candidates">
            <Icon name="list" />
            <strong>Adaylar</strong>
          </Link>
        </Menu.Item>
        <Menu.Item style={{ margin: "2em 2em 1em 0em", padding: "2em 0em 1em 2em"}}>
          <Link to="/employers">
          <Icon name="list" />
          <strong>Şirketler</strong> 
          </Link>
        </Menu.Item>
        <Menu.Item style={{ margin: "2em 2em 1em 0em", padding: "2em 0em 1em 2em"}}>
          <Link to="/jobpositions">
          <Icon name="list" />
          <strong>İş Pozisyonları</strong> 
          </Link>
        </Menu.Item>
        <Menu.Item style={{ margin: "2em 2em 1em 0em", padding: "2em 0em 1em 2em"}}>
          <Link to="#">
          <Icon name="list" />
          <strong>Boş Alan1</strong>  
          </Link>
        </Menu.Item>
        <Menu.Item style={{ margin: "2em 2em 1em 0em", padding: "2em 0em 1em 2em"}}>
          <Link to="#">
          <Icon name="list" />
          <strong>Boş Alan2</strong>
          </Link>
        </Menu.Item>
        <Menu.Item style={{ margin: "2em 2em 1em 0em", padding: "2em 0em 1em 2em"}}>
          <Link to="#">
          <Icon name="list" />
          <strong>Boş Alan3</strong>
          </Link>
        </Menu.Item>
      </Menu>
    </div>
  );
}
