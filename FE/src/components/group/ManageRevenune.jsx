/* eslint-disable react/prop-types */
/* eslint-disable no-prototype-builtins */
/* eslint-disable react-hooks/exhaustive-deps */
import { useEffect, useState } from "react";

// eslint-disable-next-line react/prop-types
const ManageRevenune = ({ trigger, result }) => {
  console.log("result: ", result);
  const [data, setData] = useState();

  useEffect(() => {
    let newArray = [];

    for (const key in result) {
      if (result.hasOwnProperty(key)) {
        const item = result[key][0];
        const newObj = {
          time: key,
          total_water: item.total_water,
          total_money: item.total_money,
        };
        newArray.push(newObj);
      }
    }
    setData(newArray);
    console.log("newArray: ", newArray);

    // console.log("arr: ", arr);
  }, [trigger]);

  return (
    <div className="relative overflow-x-auto shadow-lg sm:rounded-lg mt-8 mb-20">
      <table className="w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400">
        <thead className="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
          <tr className="bg-slate-200 font-bold">
            <th scope="col" className="px-6 py-3 text-center">
              STT
            </th>
            <th scope="col" className="px-6 py-3 text-center">
              Time (Month/ Quarter/ Year)
            </th>
            <th scope="col" className="px-6 py-3 text-center">
              Total Water
            </th>
            <th scope="col" className="px-6 py-3 text-center">
              Total Revenue (VNĐ)
            </th>
          </tr>
        </thead>
        <tbody>
          {data &&
            data.map((item, idx) => {
              return (
                <tr
                  key={idx}
                  className="odd:bg-white odd:dark:bg-gray-900 even:bg-gray-50 even:dark:bg-gray-800 border-b dark:border-gray-700 "
                >
                  <th
                    scope="row"
                    className="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white text-center"
                  >
                    {idx + 1}
                  </th>
                  <td className="px-6 py-4 text-center">{item.time}</td>
                  <td className="px-6 py-4 text-center">{item.total_water}</td>
                  <td className="px-6 py-4 text-center">{item.total_money}</td>
                </tr>
              );
            })}
        </tbody>
      </table>
    </div>
  );
};

export default ManageRevenune;
