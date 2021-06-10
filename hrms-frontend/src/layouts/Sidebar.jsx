import React from "react";
import { Link } from "react-router-dom";
import { Menu, Icon } from "semantic-ui-react";

export default function SideBar() {
  return (
    <div>
      <Menu
        inverted
        vertical
        fixed="left"
        style={{ margin: "4em 0em 0em 0em", padding: "3em 0em" }}
      >
        <Menu.Item style={{ margin: "2em 2em 1em 2em", padding: "2em 0em 1em 2em"}}>
          <Link to="/candidates" >
            <Icon name="list" />
            Candidates
          </Link>
        </Menu.Item>
        <Menu.Item style={{ margin: "2em 2em 1em 2em", padding: "2em 0em 1em 2em"}}>
          <Link to="/employers">
          <Icon name="list" />
          Employers
          </Link>
        </Menu.Item>
        <Menu.Item style={{ margin: "2em 2em 1em 2em", padding: "2em 0em 1em 2em"}}>
          <Link to="/jobpositions">
          <Icon name="list" />
          Job Positions
          </Link>
        </Menu.Item>
        <Menu.Item style={{ margin: "2em 2em 1em 2em", padding: "2em 0em 1em 2em"}}>
          <Link to="#">
          <Icon name="list" />
          Boş Alan1
          </Link>
        </Menu.Item>
        <Menu.Item style={{ margin: "2em 2em 1em 2em", padding: "2em 0em 1em 2em"}}>
          <Link to="#">
          <Icon name="list" />
          Boş Alan2
          </Link>
        </Menu.Item>
        <Menu.Item style={{ margin: "2em 2em 1em 2em", padding: "2em 0em 1em 2em"}}>
          <Link to="#">
          <Icon name="list" />
          Boş Alan3
          </Link>
        </Menu.Item>
      </Menu>
    </div>
  );
}
