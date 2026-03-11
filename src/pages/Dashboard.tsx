import TaskList from "../components/TaskList"
import TaskForm from "../components/TaskForm"

export default function Dashboard(){

 return(

  <div>

   <h1>Task Manager</h1>

   <TaskForm/>

   <TaskList/>

  </div>

 )

}