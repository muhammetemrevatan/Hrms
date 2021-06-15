import React from "react";
import {
  Container,
  Divider,
  Grid,
  Header,
  List,
  Segment,
  Button,
  Icon,
  Menu,
} from "semantic-ui-react";

export default function footer() {
  return (
    <div>
      <Segment inverted>
        <Container>
          <Grid columns={3} style={{ margin: "1em" }}>
            <Grid.Column>
              <List>
                <Header inverted as="h3" content="Trimmer" />
                <List.Item></List.Item>
                <List.Item>
                  <List.Icon name="users" />
                  <List.Content>kodlamaio</List.Content>
                </List.Item>
                <List.Item>
                  <List.Icon name="marker" />
                  <List.Content>Istanbul,Turkey</List.Content>
                </List.Item>
                <List.Item>
                  <List.Icon name="mail" />
                  <List.Content>
                    <a href="muhammetemrevatan@gmail.com">
                      muhammetemrevatan@gmail.com
                    </a>
                  </List.Content>
                </List.Item>
              </List>
            </Grid.Column>

            <Grid.Column>
              <br />
              <Icon name="react" size="huge" />
            </Grid.Column>

            <Grid.Column>
              <Header inverted as="h3" content="Follow Us" />
              <Button circular color="twitter" icon="instagram" />
              <br />
              <Button circular color="linkedin" icon="linkedin" />
              <Button circular color="google plus" icon="youtube" />
            </Grid.Column>
          </Grid>

          <Divider />

          <List horizontal divided size="small">
            <List.Item as="a" href="#">
              Home
            </List.Item>
            <List.Item as="a" href="#">
              Contact
            </List.Item>
            <List.Item as="a" href="#">
              Terms and Conditions
            </List.Item>
            <List.Item as="a" href="#">
              Privacy Policy
            </List.Item>
          </List>

          <Segment vertical>
            <List link inverted size="small">
              <List.Item>2021 Edited by Muhammet Emre Vatan.</List.Item>
            </List>
          </Segment>
        </Container>
      </Segment>
    </div>
  );
}
