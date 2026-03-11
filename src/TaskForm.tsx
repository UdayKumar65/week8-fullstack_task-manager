import { useState } from "react"
import { api } from "../services/api"

export default function TaskForm(){

 const [title,setTitle] = useState("")
 const [description,setDescription] = useState("")

 const submit = async () => {

  await api.post("/tasks",{
   title,
   description,
   status:"PENDING"
  })

 }

 return(

  <div>

   <input
    placeholder="Title"
    onChange={(e)=>setTitle(e.target.value)}
   />

   <input
    placeholder="Description"
    onChange={(e)=>setDescription(e.target.value)}
   />

   <button onClick={submit}>Add Task</button>

  </div>

 )

}