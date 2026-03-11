import { useEffect, useState } from "react"
import { api } from "../services/api"

export default function TaskList(){

 const [tasks,setTasks] = useState([])

 useEffect(()=>{
  loadTasks()
 },[])

 const loadTasks = async () => {

  const res = await api.get("/tasks")
  setTasks(res.data)

 }

 return(

  <div>

   <h2>Tasks</h2>

   {tasks.map((task:any)=>(

    <div key={task.id}>
     <h3>{task.title}</h3>
     <p>{task.description}</p>
    </div>

   ))}

  </div>

 )

}