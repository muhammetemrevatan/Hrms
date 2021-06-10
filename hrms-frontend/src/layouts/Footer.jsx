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
} from "semantic-ui-react";

export default function footer() {
  return (
    <div>
      <Segment inverted>
        <Grid>
          <Grid.Row>
            <Grid.Column width={3}></Grid.Column>

            <Grid.Column width={13}>
              <Segment
                inverted
                style={{ margin: "0em 0em 0em 0em", padding: "2em 0em" }}
              >
                <Container>
                  <Grid divided inverted stackable columns={3}>
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

                  <Divider inverted section />
                  <List horizontal inverted divided size="small">
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

                  <Segment
                    inverted
                    vertical
                    style={{ margin: "0em 0em 0em 0em", padding: "0em 0em" }}
                  >
                    <List link inverted size="small">
                      <List.Item as="a" href="#">
                        2021 Edited by Muhammet Emre Vatan.
                      </List.Item>
                    </List>
                  </Segment>
                </Container>
              </Segment>
            </Grid.Column>
          </Grid.Row>
        </Grid>
      </Segment>
    </div>
  );
}
