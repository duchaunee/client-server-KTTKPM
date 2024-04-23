import React from "react";

const Input = ({ setSelect, handleRevenue, result, setTrigger, children }) => {
  return (
    <div className="flex gap-6">
      <div className="relative cursor-pointer">
        <label
          htmlFor="from"
          className="absolute top-0 translate-y-[-50%] left-[10px] bg-white px-2 text-[14px] text-blue-700"
        >
          {children}
        </label>
        <select
          id="countries"
          name="customer_id"
          onChange={(e) => setSelect(e.target.value)}
          className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500 cursor-pointer w-[180px]"
        >
          <option selected value="month">
            Month
          </option>
          <option value="quarter">Quarter</option>
          <option value="year">Year</option>
        </select>
      </div>
      <button
        onClick={() => {
          handleRevenue(result);
          setTrigger((prev) => !prev);
        }}
        type="button"
        className="text-white bg-blue-700 hover:bg-blue-800 focus:outline-none  focus:ring-blue-300 active:scale-95 font-medium text-sm px-3 py-2 text-center ml-2 select-none"
      >
        Thống kê
      </button>
    </div>
  );
};

export default Input;
