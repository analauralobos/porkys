import React, { useEffect, useState } from 'react';
import { getAllAdmins } from '../../services/AdminService';

function AdminList() {
  const [admins, setAdmins] = useState([]);

  useEffect(() => {
    getAllAdmins().then((response) => setAdmins(response.data));
  }, []);

  return (
    <ul>
      {admins.map((admin) => (
        <li key={admin.id_administrador}>{admin.nombre} {admin.apellido}</li>
      ))}
    </ul>
  );
}

export default AdminList;
