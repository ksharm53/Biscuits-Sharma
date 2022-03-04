import { useState } from "react";

function CreateNewProject() {
  const [name, setName] = useState("");
  const [description, setDescription] = useState("");

  function onNameChange(event) {
    setName(event.target.value);
  }

  function onDescriptionChange(event) {
    setDescription(event.target.value);
  }

  return (
    <div>
      <form style={{ padding: "10px 20px" }}>
        <input placeholder="Enter project name" value={name} onChange={onNameChange} />
        <br />
        <input placeholder="Enter project description" value={description} onChange={onDescriptionChange} />
        <br />

        <p>Do you want team members?</p>
        <input type="radio" value="yes" /> Yes<br />
        <input type="radio" value="no" /> No
        <br />
        <textarea />

        <br />
        <p>Github URL</p>
        <input type="text" />

        <br />

        <p>Do you want to connect with Slack channel?</p>

        <input type="radio" value="yes" /> Yes<br />
        <input type="radio" value="no" /> No
        <br />

        <p>Do you want to add this Project to Taiga?</p>

        <input type="radio" value="yes" /> Yes<br />
        <input type="radio" value="no" /> No
        <br />
        <button>Save</button>
      </form>
    </div>
  );
}

export default CreateNewProject;
