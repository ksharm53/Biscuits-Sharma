import { useState } from "react";

function CreateNewProject() {
  const [name, setName] = useState("");
  const [description, setDescription] = useState("");

  function onNameChange (event) {
    setName(event.target.value);
  }

  function onDescriptionChange (event) {
    setDescription(event.target.value);
  }

  return (
    <div>
      <form style={{ padding: "10px 20px"}}>
        <input placeholder="Enter project name" value={name} onChange={onNameChange} />
        <br /><br />
        <input placeholder="Enter project description" value={description} onChange={onDescriptionChange} />
        <br /><br />
        <button>Save</button>
      </form>
    </div>
  );
}

export default CreateNewProject;
